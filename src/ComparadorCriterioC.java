import java.util.Comparator;

/**
 * Critério C - Índice de Economia (decrescente).
 * O índice de economia é a diferença entre o valor de catálogo atual e o valor efetivamente pago.
 * Desempate 1: Valor Final do Pedido (crescente).
 * Desempate 2: Código Identificador do pedido (crescente).
 */
public class ComparadorCriterioC implements Comparator<Pedido> {

    ComparadorCriterioC comparadorAuxiliar;

    @Override
    public int compare(Pedido o1, Pedido o2) {
        if ((o1.valorFinal()/o1.getQuantItens()) == (o2.valorFinal()/o2.getQuantItens())) {
            if (o1.getTotalItens() == o2.getTotalItens()) {
                return o1.compareTo(o2);
            } else if (o1.getTotalItens() < o2.getTotalItens()) {
                return -1;
            } else {
                return 1;
            }
        } else if ((o1.valorFinal()/o1.getQuantItens()) < (o2.valorFinal()/o2.getQuantItens())) {
            return -1;
        } else {
            return 1;
        }
    }
}
