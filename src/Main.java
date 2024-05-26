/*
*Este exercício consiste em escrever um programa que recebe um texto como entrada do úsuario. O programa deve:
* 1°contar quantas palavras aparecem na frase;
* 2°Imprimir cada palavra apenas uma vez e dizer quantas vezes essa mesma palavra está repetida no texto;
* 3°Imprimir as palavras em ordem alfabetica.
*
* Exemplo:
* cachorro: 2
* corre: 1
* e: 1
* gato: 1
* o: 2
* rápido: 1
* também: 1
*
*/

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static final  char NULO = ' ';
    public static StringBuilder builder = new StringBuilder();

    public static void main(String[] args) {

        LinkedList<String> lista = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nEscreva um texto:");
        String[] string = new StringBuilder(scanner.nextLine()).toString().split(" ");

        eliminandoSinais(string, lista);
        enumerarPalavrasRepetidas(lista);

        System.out.printf("%n%s%d%n","Quantidade de palavras armazenadas na lista: ", lista.size());

    }

    //O método 'enumerarPalavrasRepetidas' serve para fazer a contagem das palavras e dizer quantas vezes uma palavra foi repetida;
    public static void enumerarPalavrasRepetidas(LinkedList<String> lista){
        for (int i = 0; i < lista.size() ; i++) {
            int quantidade = 1;

            for (int j = i + 1; j < lista.size() ; ) {

                if(lista.get(i).equals(lista.get(j))) {
                    lista.remove(j);
                    quantidade++;
                    j = i + 1;
                } else
                    j++;

            }
            System.out.printf("%n%s%s\t\t%s%d", "Elemento: ",lista.get(i), "Repetições: ", quantidade);
        }
    }

    //Transforma todos os tokens armazenados no Array 'palavras' em Array de 'char'. Usa o método 'verificarSinais' e vai adicionado o retorno em um append() para tornar em uma palavra nova, sem os sinais;
    public static void eliminandoSinais(String[] palavras, LinkedList<String> lista) {

        for (int i = 0; i < palavras.length; i++){

            builder.delete(0, builder.length());
            char[] character = new char[palavras[i].length()];
            palavras[i].getChars(0, character.length , character, 0);

            for (int j = 0; j < character.length; j++) {

                builder.append(verificarSinais(character[j]));

                if (j == character.length - 1)
                    lista.add(builder.toString().trim());

            }
        }
    }

    //Retorna todos os caracteres listados como 'sinais' em espaço vazio;
    public static char verificarSinais(char character){
        char[] sinais = {'!', '\"', '@', '#', '$', '%', '¨', '&', '*', '(', ')',  '_', '-', '+', '=', ',', '.',  '<', '>', '/', '?', '°', ':',  ';'};

        for (char c : sinais)
            if (character == c)
                character = NULO;

        return character;
    }
}