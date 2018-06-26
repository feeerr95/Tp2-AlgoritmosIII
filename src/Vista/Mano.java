package Vista;

import fiuba.algo3.tp2.Jugador;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import java.util.ArrayList;

public class Mano extends HBox {

    private ArrayList<BotonCartaMonstruo> botonesCartasMonstruo;
    private ArrayList<BotonCartaEfecto> botonesCartasEfecto;
    private ContenedorPrincipalPrueba contenedorPrincipalPrueba;
    private Jugador jugador;

    public Mano(Jugador jugador, ContenedorPrincipalPrueba contenedorPrincipalPrueba) {

        this.jugador = jugador;
        this.contenedorPrincipalPrueba = contenedorPrincipalPrueba;
    }

    public ArrayList<BotonCartaMonstruo> getBotonesDeLaMano() {
        return this.botonesCartasMonstruo;
    }

    public void setBotonesEnLaMano(ArrayList<BotonCartaMonstruo> listaDeBotones) {
        this.botonesCartasMonstruo = listaDeBotones;
    }

    public void setCarta(Button carta) {
        this.getChildren().add(carta);
    }

    public void getCarta(Button carta) {
        this.getChildren().remove(carta);
    }
}

//    public void update(Jugador jugador){
//        this.removeAll();
//        this.revalidate();
//        botonesCartasMonstruo = new ArrayList<BotonCartaMonstruo>(20);
//        botonesCartasEfecto = new ArrayList<BotonCartaEfecto>(20);
//        ArrayList<Carta> mano = jugador.getMano();
//        this.setLayout(new FlowLayout());
//        this.setOpaque(false);
//
//        this.actualizarBotonesMonstruo();
//        this.actualizarBotonesEfecto();
//    }
//
//    private void actualizarBotonesMonstruo(){
//        for (int i = 0; i <20; i++) {
//            BotonCartaMonstruo carta = new BotonCartaMonstruo();
//            carta.setVisible(false);
//            this.add(carta);
//            botonesCartasMonstruo.add(carta);
//        }
//    }
//
//    private void actualizarBotonesEfecto(){
//        for (int i = 0; i <20; i++) {
//            BotonCartaEfecto carta = new BotonCartaEfecto();
//            carta.setVisible(false);
//            this.add(carta);
//            botonesCartasEfecto.add(carta);
//        }
//    }
//
//
//
//}
//
//        for(int i = 0; i <hand.size();i++){
//            if(hand.get(i) instanceof MonsterCard){
//                //monsterbuttons.get(i).setText(hand.get(i).getName());
//                monsterbuttons.get(i).setMonster((MonsterCard) hand.get(i));
//                monsterbuttons.get(i).setVisible(true);
//                ImageIcon img = new ImageIcon("Cards Images Database/Monsters/"+hand.get(i).getName()+".png");
//                Image img2 = img.getImage();
//                Image newimg = img2.getScaledInstance(100, 146,  java.awt.Image.SCALE_SMOOTH);
//                ImageIcon newIcon = new ImageIcon(newimg);
//                monsterbuttons.get(i).setIcon(newIcon);
//                monsterbuttons.get(i).setPreferredSize(new Dimension(100,146));
//                monsterbuttons.get(i).revalidate();
//                monsterbuttons.get(i).setOpaque(false);
//                monsterbuttons.get(i).repaint();
//                //monsterbuttons.add(mb);
//                //this.add(mb);
//            }
//            else{
//                //spellbuttons.get(i).setText(hand.get(i).getName());
//                spellbuttons.get(i).setSpell((SpellCard) hand.get(i));
//                spellbuttons.get(i).setVisible(true);
//                ImageIcon img = new ImageIcon("Cards Images Database/Spells/"+hand.get(i).getName()+".png");
//                Image img2 = img.getImage();
//                Image newimg = img2.getScaledInstance(100, 146,  java.awt.Image.SCALE_SMOOTH);
//                ImageIcon newIcon = new ImageIcon(newimg);
//                spellbuttons.get(i).setIcon(newIcon);
//                spellbuttons.get(i).setPreferredSize(new Dimension(100,146));
//                spellbuttons.get(i).revalidate();
//                spellbuttons.get(i).setOpaque(false);
//                spellbuttons.get(i).repaint();
//            }
//        }
//    }
//    public ArrayList<MonsterButton> getMonsterbuttons() {
//        return monsterbuttons;
//    }
//    public void setMonsterbuttons(ArrayList<MonsterButton> monsterbuttons) {
//        this.monsterbuttons = monsterbuttons;
//    }
//    public ArrayList<SpellButton> getSpellbuttons() {
//        return spellbuttons;
//    }
//    public void setSpellbuttons(ArrayList<SpellButton> spellbuttons) {
//        this.spellbuttons = spellbuttons;
//    }
//
//}
