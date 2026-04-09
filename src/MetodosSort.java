public class MetodosSort{


    private static int[] ordenarBubble(int[] vet){
        for(int i = (vet.length - 1); i > 0; i--){
            for(int j = 0; j < i; j++){
                if(vet[j] > vet[j+1]){
                    int temp = vet[j+1];
                    vet[j+1] = vet[j];
                    vet[j] = temp;
            
                }
            }
        }

        return vet;
    }

    private static int[] ordenarSelection(int[] vet){
        for(int i = 0; i<(vet.length - 1); i++){
            int menor = i;
            for(int j=i+1; j<vet.length; j++){
                if(vet[j] < vet[menor])
                    menor = j;
            }
            int temp = vet[i];
            vet[i] = vet[menor];
            vet[menor] = temp;
        }

        return vet;
    }

    private static int[] ordenarInsertion(int[] vet){
        for(int i = 1; i<vet.length; i++){
            int ref = vet[i];
            int j = i;
            while((j > 0) && (vet[j-1] > ref)){
                vet[j] = vet[j-1];
                j--;
            }
            vet[j] = ref;
        }

        return vet;
    }

    public static void main(String[] args) {
        int[] vet = {4, 5, 7, 1};

        int[] vetOrdenado = ordenarInsertion(vet);

        for(int i = 0; i < vetOrdenado.length; i++)
            System.out.println(vetOrdenado[i]);
        
    }
}