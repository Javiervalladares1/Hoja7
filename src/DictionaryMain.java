package src;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;


public class DictionaryMain {
    public static void main(String[] args) {
        BinaryTree<DictionaryEntry> tree = new BinaryTree<>();
        Scanner scanner = new Scanner(System.in);

        // Construir árbol a partir del archivo diccionario.txt
        try {
            BufferedReader reader = new BufferedReader(new FileReader("diccionario.txt"));
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                String englishWord = parts[0].trim().toLowerCase();
                String spanishWord = parts[1].trim().toLowerCase();
                String frenchWord = parts[2].trim().toLowerCase();

                DictionaryEntry entry = new DictionaryEntry(englishWord, spanishWord, frenchWord);
                tree.insert(entry);
            }
            reader.close();

            System.out.println("Contenido del árbol después de la inserción:");
            tree.inOrderTraversal();
            System.out.println(); // Nueva línea para mejorar la legibilidad
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Solicitar al usuario el idioma del texto
        System.out.println("Ingrese el idioma del texto (1. inglés, 2. español, 3. francés):");
        int sourceLanguage = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer del scanner

        // Solicitar al usuario el idioma al que desea traducir
        System.out.println("Seleccione el idioma al que desea traducir (1. inglés, 2. español, 3. francés):");
        int targetLanguage = scanner.nextInt();
        scanner.nextLine();  // Limpiar el buffer del scanner

        // Procesar archivo texto.txt y realizar traducción
        try {
            BufferedReader reader = new BufferedReader(new FileReader("texto.txt"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] words = line.split(" ");
                for (String word : words) {
                    String translation = null;
                    DictionaryEntry wordEntry = null;
                    switch (sourceLanguage) {
                        case 1:
                            wordEntry = new DictionaryEntry(word.toLowerCase(), null, null);
                            break;
                        case 2:
                            wordEntry = new DictionaryEntry(null, word.toLowerCase(), null);
                            break;
                        case 3:
                            wordEntry = new DictionaryEntry(null, null, word.toLowerCase());
                            break;
                        default:
                            break;
                    }
                    if (wordEntry != null) {
                        DictionaryEntry result = tree.search(wordEntry);
                        if (result != null) {
                            switch (targetLanguage) {
                                case 1:
                                    translation = result.getEnglishWord();
                                    break;
                                case 2:
                                    translation = result.getSpanishWord();
                                    break;
                                case 3:
                                    translation = result.getFrenchWord();
                                    break;
                                default:
                                    break;
                            }
                        }
                    }
                    if (translation != null) {
                        System.out.print(translation + " ");
                    } else {
                        System.out.print("*" + word + "* ");
                    }
                }
                System.out.println();
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
