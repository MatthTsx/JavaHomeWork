import javax.swing.JOptionPane;

public class App {
    static class dominio_1{
        String title;
        dominio_1[] Options;
        String resp;

        dominio_1(String title, dominio_1[] Options, String resp){
            this.title = title;

            if(Options.length > 0){
                this.Options = Options;
            }else{
                this.resp = resp;
            }
        }

        public void selected(){
            if(this.Options == null){
                JOptionPane.showMessageDialog(null, resp, "O animal escolhido é: ", 0);
                return;
            }
            for(int i = 0; i < this.Options.length; i++){
                int confirm = JOptionPane.showConfirmDialog(null, "o animal é: " + this.Options[i].title + " ?");
                if(confirm == 0){
                    this.Options[i].selected();
                    break;
                }
            }
        }

    }
    public static void main(String[] args) throws Exception {
        dominio_1[] nada = {};
        
        dominio_1[] Bipedes_ = {
            new dominio_1("Onivoros", nada, "Homem"),
            new dominio_1("Frutivoros", nada, "Macaco"),
        };
        dominio_1[] Quadrupedes_ = {
            new dominio_1("Carniveros", nada, "Leao"),
            new dominio_1("Bipedes", nada, "Cavalo"),
        };

        dominio_1[] Mamifero_ = {
            new dominio_1("Quadrupedes", Quadrupedes_, ""),
            new dominio_1("Bipedes", Bipedes_, ""),
            new dominio_1("Voadores", nada, "Morcego"),
            new dominio_1("Aquaticos", nada, "Baleia"),
        };
        dominio_1 Mamifero = new dominio_1("Mamifero", Mamifero_, "");

        //AVES

        dominio_1[] Nao_voadoras_ = {
            new dominio_1("Tropicais", nada, "Avestruz"),
            new dominio_1("Polares", nada, "Pinguim"),
        };
        dominio_1[] Aves_ = {
            new dominio_1("Nao-Voadoras", Nao_voadoras_, ""),
            new dominio_1("Nadadoras", nada, "Pato"),
            new dominio_1("De rapina", nada, "Aguia"),
        };
        dominio_1 aves = new dominio_1("Aves", Aves_, "");

        //Reptils

        dominio_1[] reptils_ = {
            new dominio_1("Com casco", nada, "Tartaruga"),
            new dominio_1("Carnivoro", nada, "Crocodilo"),
            new dominio_1("Sem patas", nada, "Cobra"),
        };
        dominio_1 reptils = new dominio_1("Reptils", reptils_, "");

        dominio_1[] first = {
            Mamifero,
            aves,
            reptils
        };

        dominio_1 start = new dominio_1("Selecione um", first, "");
        start.selected();
    }
}
