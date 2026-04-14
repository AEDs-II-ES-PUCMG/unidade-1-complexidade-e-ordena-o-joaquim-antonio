import java.util.Random;

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

    public static void main(String[] args) {
        for(int i=1; i<5; i++){
            int tam = 10 * i;
            System.out.println("\n====================================="+
                            "\nTESTES PARA UM VETOR DE TAMANHO " + tam);

            //testando o bubble sort
            Integer[] vetor = gerarVetorObjetos(tam);

            BubbleSort<Integer> bolha = new BubbleSort<>();

            Integer[] vetorOrdenado = bolha.ordenar(vetor);

            System.out.println("\nVetor ordenado método Bolha:");
            for(int numero : vetorOrdenado){
                System.out.print(numero + " ");
            }
            System.out.println("\nComparações: " + bolha.getComparacoes());
            System.out.println("Movimentações: " + bolha.getMovimentacoes());
            System.out.println("Tempo de ordenação (ms): " + bolha.getTempoOrdenacao());


            //testando o insertion sort
            vetor = gerarVetorObjetos(tam);
            InsertionSort<Integer> insertion = new InsertionSort<>();

            vetorOrdenado = insertion.ordenar(vetor);

            System.out.println("\nVetor ordenado método Insertion:");
            for(int numero : vetorOrdenado){
                System.out.print(numero + " ");
            }
            System.out.println("\nComparações: " + insertion.getComparacoes());
            System.out.println("Movimentações: " + insertion.getMovimentacoes());
            System.out.println("Tempo de ordenação (ms): " + insertion.getTempoOrdenacao());


            //testando o selection sort
            vetor = gerarVetorObjetos(tam);
            SelectionSort<Integer> selection = new SelectionSort<>();

            vetorOrdenado = selection.ordenar(vetor);

            System.out.println("\nVetor ordenado método Selection:");
            for(int numero : vetorOrdenado){
                System.out.print(numero + " ");
            }
            System.out.println("\nComparações: " + selection.getComparacoes());
            System.out.println("Movimentações: " + selection.getMovimentacoes());
            System.out.println("Tempo de ordenação (ms): " + selection.getTempoOrdenacao());
        }
    }
}
