import Debug.Trace

data Osoba = Osoba String

instance Show Osoba where
  show (Osoba imie) = imie

rodzic :: Osoba -> Osoba -> Bool
rodzic (Osoba "piotr") (Osoba "ewa") = True
rodzic (Osoba "adam") (Osoba "ania") = True
rodzic (Osoba "adam") (Osoba "ewa") = True
rodzic _ _ = False

jestRodzicem :: Osoba -> Osoba -> Maybe Bool
jestRodzicem osoba dziecko = traceShow (osoba, dziecko) $ do
  if rodzic osoba dziecko
    then do
      traceM $ show osoba ++ " jest rodzicem " ++ show dziecko
      return True
    else do
      traceM $ show osoba ++ " nie jest rodzicem " ++ show dziecko
      Nothing

przodkowie :: Osoba -> [Osoba] -> [Osoba]
przodkowie osoba [] = []
przodkowie osoba (x:xs) =
  case jestRodzicem osoba x of
    Just True -> do
      traceM $ show x ++ " jest przodkiem " ++ show osoba
      x : przodkowie osoba xs
    Just False -> do
      traceM $ show x ++ " nie jest przodkiem " ++ show osoba
      przodkowie osoba xs
    Nothing -> do
      traceM $ "Nie można ustalić relacji między " ++ show osoba ++ " a " ++ show x
      przodkowie osoba xs
predykatyRodzicow :: [Osoba -> Osoba -> Bool]
predykatyRodzicow = [rodzic]




main :: IO ()
main = do
  let przodkowieEwy = przodkowie (Osoba "ewa") [Osoba "piotr", Osoba "adam"]
  putStrLn ("Przodkowie Ewy: " ++ show przodkowieEwy)
  let przodkowiePiotra = przodkowie (Osoba "piotr") [Osoba "ewa", Osoba "adam"]
  putStrLn ("Przodkowie Piotra: " ++ show przodkowiePiotra)
  let przodkowieAdama = przodkowie (Osoba "adam") [Osoba "ania", Osoba "ewa"]
  putStrLn ("Przodkowie Adama: " ++ show przodkowieAdama)

