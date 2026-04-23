import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Comparator;
import java.time.Duration;

public class HeapSort<T extends Comparable<T>> implements IOrdenador<T> {

    private long comparacoes;
    private long movimentacoes;
    private LocalDateTime inicio;
    private LocalDateTime termino;

    @Override
    public T[] ordenar(T[] dados) {
        return ordenar(dados, T::compareTo);
    }

    @Override
    public T[] ordenar(T[] vetor, Comparator<T> comparador) {

        inicio = LocalDateTime.now();

        T[] tmp = Arrays.copyOf(vetor, vetor.length+1);
        for (int i = 0; i < vetor.length; i++) {
            tmp[i + 1] = vetor[i];
        }

        for (int tamHeap = (tmp.length - 1) / 2; tamHeap >= 1; tamHeap--) {
            restaura(tmp, tamHeap, tmp.length - 1, comparador);
        }

        int tamHeap = tmp.length - 1;
        trocar(tmp, 1, tamHeap--);
        while (tamHeap > 1) {
            restaura(tmp, 1, tamHeap, comparador);
            trocar(tmp, 1, tamHeap--);
        }

        for (int i = 0; i < vetor.length; i++) {
            vetor[i] = tmp[i + 1];
        }

        termino = LocalDateTime.now();

        return vetor;
    }

    private void restaura(T[] vetor, int i, int tamHeap, Comparator<T> comparador) {
        int maior = i;
        int filho = getMaiorFilho(vetor, i, tamHeap, comparador);

        // Se o maior filho supera o nó atual, ele passa a ser o candidato à troca
        if (comparador.compare(vetor[filho], vetor[i]) > 0) {
            maior = filho;
        }

        if (maior != i) {
            trocar(vetor, i, maior);
            // Desce recursivamente apenas se o nó que desceu ainda tem filhos
            if (maior <= tamHeap / 2) {
                restaura(vetor, maior, tamHeap, comparador);
            }
        }
    }

    private int getMaiorFilho(T[] vetor, int i, int tamHeap, Comparator<T> comparador) {
        int filho;
        if (2 * i == tamHeap || comparador.compare(vetor[2 * i], vetor[2 * i + 1]) > 0) {
            filho = 2 * i; // filho esquerdo
        } else {
            filho = 2 * i + 1; // filho direito
        }
        return filho;
    }

    private void trocar(T[] vetor, int i, int j) {
        movimentacoes++;

        T temp = vetor[i];
        vetor[i] = vetor[j];
        vetor[j] = temp;
    }

    public long getComparacoes() {
        return comparacoes;
    }

    public long getMovimentacoes() {
        return movimentacoes;
    }

    public double getTempoOrdenacao() {
        return Duration.between(inicio, termino).toMillis();
    }
}