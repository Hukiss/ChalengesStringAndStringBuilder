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
 */

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        LinkedList<String> lista = new LinkedList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("\n\nEscreva um texto:");
        String string = scanner.nextLine();

        char[] character = new char[string.length()];
        string.getChars(0, string.length(), character, 0);

        eliminandoSinais(character);
        listarPalavras(lista, character);

        System.out.printf("%n%s%d%n","Quantidade de palavras armazenadas na lista: ", lista.size());

        eliminarPalavrasRepetidas(lista);

    }

    /*
    *É neste método onde todas as palavras são armazenadas usando a estrutura de dados fornecido pelo Java a LinkedList.
    * Tudo isso foi feito graças ao uso da classe StringBuilder com o seu método append().
    * Transformei todo texto em um array de char e percorrri ela usando o foreach e o for com condição.
     */
    public static void listarPalavras(LinkedList<String> lista, char[] character){
        StringBuilder builder = new StringBuilder();

        for (int i = 0;i < character.length; i++){
            if (character[i] == ' '){

                if (!(character[i - 1] == ' ')){
                    lista.add(builder.toString());
                    builder.delete(0, builder.length());
                }

            } else if (i == character.length - 1) {
                builder.append(character[i]);
                lista.add(builder.toString());
            } else
                builder.append(character[i]);
        }
    }

    /*
    *Assim como o nome do método diz, ele elimina as palavras repetidas e ao mesmo temmpo
    * faz a contagem de todas as palavras e as imprimi para melhor organização
     */
    public static void eliminarPalavrasRepetidas(LinkedList<String> lista){

        for (int i = 0; i < lista.size() - 1; i++) {

            int quantidade = 1;

            for (int j = i + 1; j < lista.size() ; ) {
                if(lista.get(i).equals(lista.get(j))) {
                    lista.remove(j);
                    quantidade++;
                    j = i + 1;
                } else {
                    j++;
                }
            }
            System.out.printf("%n%s%s\t%s%d", "Elemento: ", "Retições: ",lista.get(i), quantidade);
        }
    }

    /*
    *Este metódo é usado para eliminar todos os sinais da lingua portuguesa (dentro do texto), sinais como:
    *   , . < > ; : ! @ # $ % ¨ & * ( ) - _ + = ' entre outros sinais existentes
     */
    public static void eliminandoSinais(char[] character){

        char[] sinais = {'!', '\"', '@', '#', '$', '%', '¨', '&', '*', '(', ')', '_', '-', '+', '=', ',', '.', '<', '>', '/', '?', '°', ':', ';'};

        for (int i = 0; i < character.length; i++){
            for (char sinal : sinais)
                if (character[i] == sinal)
                    character[i] = ' ';
        }
    }
}