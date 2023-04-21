import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.util.Vector;


public class Main {
    public static void main(String[] args) {

        // Données de la JTable sous forme de vecteurs
                Vector<Vector<Object>> data = new Vector<Vector<Object>>();
                Vector<Object> row1 = new Vector<Object>();
                row1.add("John");
                row1.add("Doe");
                row1.add(28);
                data.add(row1);
                Vector<Object> row2 = new Vector<Object>();
                row2.add("Jane");
                row2.add("Doe");
                row2.add(25);
                data.add(row2);
                Vector<Object> row3 = new Vector<Object>();
                row3.add("Bob");
                row3.add("Smith");
                row3.add(35);
                data.add(row3);

                // Noms de colonnes de la JTable sous forme de vecteur
                Vector<String> columnNames = new Vector<String>();
                columnNames.add("Prénom");
                columnNames.add("Nom");
                columnNames.add("Âge");

                // Création de la JTable
                JTable table = new JTable(data, columnNames);

                // Création du JScrollPane
                JScrollPane scrollPane = new JScrollPane(table);

                // Création de la JFrame
                JFrame frame = new JFrame("Exemple de JTable avec des vecteurs");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

                // Ajout du JScrollPane à la JFrame
                frame.add(scrollPane);

                // Affichage de la JFrame
                frame.pack();
                frame.setVisible(true);
            }
        }
        //frame.setLayout(new GridLayout(5,1));
        /*JButton produit_button = new JButton("Gerer Produits");
        JButton client_button = new JButton("Gerer Clients");
        JButton vendeur_button = new JButton("Gerer Vendeurs");
        JButton vente_button = new JButton("Gerer Vente");
        JButton stat_button = new JButton("Statistiques");

        frame.add(produit_button);
        frame.add(client_button);
        frame.add(vendeur_button);
        frame.add(vente_button);
        frame.add(stat_button);*/

       

        //frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

