import java.util.Comparator;

/**
 * Critério B - Volume Total de Itens (crescente).
 * Desempate 1: Data do Pedido.
 * Desempate 2: Código Identificador do pedido.
 */
public class ComparadorCriterioB implements Comparator<Pedido> {
    ComparadorCriterioA comparadorAuxiliar;

    @Override
    public int compare(Pedido o1, Pedido o2) {
        if(o1.getFormaDePagamento() == o2.getFormaDePagamento()){
            comparadorAuxiliar = new ComparadorCriterioA();
            if(comparadorAuxiliar.compare(o1, o2) == 0){
                return o1.compareTo(o2);
            }else if(comparadorAuxiliar.compare(o1, o2) < 0){
                return -1;
            }else
                return 1;
        }else if(o1.getFormaDePagamento() < o2.getFormaDePagamento()){
            return -1;
        }else
            return 1;
    }
}
