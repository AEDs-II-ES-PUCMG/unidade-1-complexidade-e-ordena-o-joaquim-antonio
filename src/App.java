import java.util.Random;
import java.util.Scanner;

public class App {

    static final int[] tamanhosTesteGrande =  { 31_250_000, 62_500_000, 125_000_000, 250_000_000, 500_000_000 };
    static final int[] tamanhosTesteMedio =   {     12_500,     25_000,      50_000,     100_000,     200_000 };
    static final int[] tamanhosTestePequeno = {          3,          6,          12,          24,          48 };
    static Random aleatorio = new Random();
    static long operacoes;
    static double nanoToMilli = 1.0/1_000_000;
    

    /**
     * Gerador de vetores aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static int[] gerarVetor(int tamanho){
        int[] vetor = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, tamanho/2);
        }
        return vetor;        
    }

    /**
     * Gerador de vetores de objetos do tipo Integer aleatórios de tamanho pré-definido. 
     * @param tamanho Tamanho do vetor a ser criado.
     * @return Vetor de Objetos Integer com dados aleatórios, com valores entre 1 e (tamanho/2), desordenado.
     */
    static Integer[] gerarVetorObjetos(int tamanho) {
        Integer[] vetor = new Integer[tamanho];
        for (int i = 0; i < tamanho; i++) {
            vetor[i] = aleatorio.nextInt(1, 10 * tamanho);
        }
        return vetor;
    }

    private static Scanner leitor = new Scanner(System.in);
    public static void main(String[] args) {
        SelectionSort<Integer> selection = new SelectionSort<>();
        InsertionSort<Integer> insertion = new InsertionSort<>();
        BubbleSort<Integer> bolha = new BubbleSort<>();
        MergeSort<Integer> merge = new MergeSort<>();
        
        int res = 1;

        do {
            System.out.println("\n=========================================================================================================" + 
                            "\nQual o método que você deseja usar? (0)Sair (1)BubbleSort (2)MergeSort (3)InsertionSort (4)SelectionSort: ");
            res = leitor.nextInt();
    
            switch (res) {
                case 1:
                    for(int i=1; i<5; i++){
                        int tam = 10*i;
                        Integer[] vetor = gerarVetorObjetos(tam);
                        Integer[] vetorOrdenado = bolha.ordenar(vetor);

                        System.out.println("\nVetor ordenado método Bolha:");
                        for(int numero : vetorOrdenado){
                        System.out.print(numero + " ");
                        }
                        System.out.println("\nComparações: " + bolha.getComparacoes());
                        System.out.println("Movimentações: " + bolha.getMovimentacoes());
                        System.out.println("Tempo de ordenação (ms): " + bolha.getTempoOrdenacao());

                    }
                    break;
                case 2:
                    for(int i=1; i<5; i++){
                        int tam = 10*i;
                        Integer[] vetor = gerarVetorObjetos(tam);
                        Integer[] vetorOrdenado = merge.ordenar(vetor);

                        System.out.println("\nVetor ordenado método merge:");
                        for(int numero : vetorOrdenado){
                        System.out.print(numero + " ");
                        }
                        System.out.println("\nComparações: " + merge.getComparacoes());
                        System.out.println("Movimentações: " + merge.getMovimentacoes());
                        System.out.println("Tempo de ordenação (ms): " + merge.getTempoOrdenacao());
                    }
                    break;
                case 3:
                    for(int i=1; i<5; i++){
                        int tam = 10*i;
                        Integer[] vetor = gerarVetorObjetos(tam);
                        Integer[] vetorOrdenado = insertion.ordenar(vetor);

                        System.out.println("\nVetor ordenado método insertion:");
                        for(int numero : vetorOrdenado){
                        System.out.print(numero + " ");
                        }
                        System.out.println("\nComparações: " + insertion.getComparacoes());
                        System.out.println("Movimentações: " + insertion.getMovimentacoes());
                        System.out.println("Tempo de ordenação (ms): " + insertion.getTempoOrdenacao());

                    }
                    break;
                case 4:
                    for(int i=1; i<5; i++){
                        int tam = 10*i;
                        Integer[] vetor = gerarVetorObjetos(tam);
                        Integer[] vetorOrdenado = selection.ordenar(vetor);

                        System.out.println("\nVetor ordenado método selection:");
                        for(int numero : vetorOrdenado){
                        System.out.print(numero + " ");
                        }
                        System.out.println("\nComparações: " + selection.getComparacoes());
                        System.out.println("Movimentações: " + selection.getMovimentacoes());
                        System.out.println("Tempo de ordenação (ms): " + selection.getTempoOrdenacao());

                    }   
                    break;
                default:
                    break;
            }

        }while (res != 0);
    }

}
