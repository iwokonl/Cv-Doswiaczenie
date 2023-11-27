import numpy as np
from PIL import Image

# Otwórz obraz
a = Image.open("Bez tytułu.png")

# Upewnij się, że obraz jest w trybie RGB
if a.mode != 'RGB':
    a = a.convert('RGB')

# Konwertuj obraz na tablicę numpy
a = np.asarray(a)

# Podziel tablicę na trzy kanały
tablica_r = a[:, :, 0]
tablica_g = a[:, :, 1]
tablica_b = a[:, :, 2]
tablica_r = Image.fromarray(tablica_r)
tablica_g = Image.fromarray(tablica_g)
tablica_b = Image.fromarray(tablica_b)

# Wyświetl każdy z kanałów
tablica_r.show()
tablica_g.show()
tablica_b.show()