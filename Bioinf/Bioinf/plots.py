
import matplotlib.pyplot as plt
import numpy as np
import pandas as pd
from scipy.stats import ttest_ind
from sklearn.preprocessing import StandardScaler
from sklearn.decomposition import PCA
# Do poprawy -Log10(p-value) bof nie wiem jak to obliczyć i czy Log2 Fold jest git

df = pd.read_csv('data/Feature_counts.txt', delimiter='\t')

# Dodaj epsilon do uniknięcia dzielenia przez zero


# Oblicz log2 fold change dla każdej pary porównań
for col in range(1, 5):
    df = df[df[f'R_fluitans_B{col}Aligned.sortedByCoord.out.bam'] != 0] # Czemu jak to dodam nie wywala Nanów

for col in range(1, 5):
    df[f'log2foldchange{col}'] = np.log2(
        df[f'R_fluitans_A{col}Aligned.sortedByCoord.out.bam'] / df[f'R_fluitans_B{col}Aligned.sortedByCoord.out.bam']) # Czyli to stosunek starej komurki do zmodyfikowanej(?) rozumiem ze tak jest i tyle czy to jakiś procent zmiany?

# Inicjalizuj DataFrame do przechowywania p-wartości dla każdego porównania
p_values_df = pd.DataFrame(index=df.index) # Co to jest p-value? value to wartość tego a p to nie wiem 0,95 * wartość tego
print(df.shape)
# Oblicz p-wartości dla każdego genu w porównaniach
for col in range(1, 5):
    treated = df[f'R_fluitans_A{col}Aligned.sortedByCoord.out.bam']
    control = df[f'R_fluitans_B{col}Aligned.sortedByCoord.out.bam']
    t_stat, p_val = ttest_ind(treated, control, equal_var=False)
    p_values_df[f'p_value{col}'] = np.log10(p_val)
    df[f'mean_average{col}'] = (np.log2(treated + 1e-9) + np.log2(control + 1e-9)) / 2
# Dodaj p-wartości z powrotem do oryginalnego DataFrame
df = pd.concat([df, p_values_df], axis=1)
arr = np.linspace(-40, -5, 15619)
# Tworzenie wykresu wulkanicznego dla pierwszego porównania
for col in range(1, 5):
    plt.plot(df[f'log2foldchange{col}'], arr, 'o',alpha=0.2, label=f'Comparison {col}')
plt.xlabel('Log2 Fold Change')
plt.ylabel('-Log10(p-value)')  # Zmodyfikowana etykieta osi Y
plt.title('Volcano Plot')
plt.show()# Jak to czytać?
for col in range(1, 5):
    plt.plot(df[f'mean_average{col}'], df[f'log2foldchange{col}'], 'o',alpha=0.2, label=f'Comparison {col}')
    plt.xlabel('A (Mean Average)')
    plt.ylabel('M (Log2 Fold Change)')
    plt.title('MA Plot')
    plt.axhline(y=0, color='gray', linestyle='--')  # Add a horizontal line at M=0
plt.show() # Jak to czytać?


df.replace([np.inf, -np.inf], np.nan, inplace=True)


df.dropna(inplace=True)




scaler = StandardScaler()
scaled_df = scaler.fit_transform(df.select_dtypes(include=[np.number]))


pca = PCA(n_components=0.95)
pca_components = pca.fit_transform(scaled_df)


plt.figure(figsize=(10, 6))
plt.scatter(pca_components[:, 0], pca_components[:, 1], alpha=0.5)
plt.title('PCA')
plt.show()# Jak to czytać?

# Na naturalnym przykładzie co to jest do czego to się uzywa i w jakim  kierunku jest to normalizacja
# (Myśl - To jest coś takiego jak min max scaling dla biasów i wag w sieci neuronowej jak chcemy znormalizować wartości dla przedziału [0-1]?)