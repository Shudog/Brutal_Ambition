import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;

/**
 * Created by Jasper on 4/23/2017.
 */
public class DnD {

    private JPanel player;
    private JLabel playerName;
    private JLabel classLevel;
    private JLabel Race;
    private JLabel alignment;
    private JLabel expierence;
    private JTextField playerNameTextField;
    private JTextField alignmentTextField;
    private JTextField classLevelTextField;
    private JTextField raceTextField;
    private JTextField experienceTextField;
    private JTextField dexterityTextField;
    private JTextField constitutionTextField;
    private JTextField intelligenceTextField;
    private JTextField wisdomTextField;
    private JTextField charismaTextField;
    private JTextField strengthTextField;
    private JLabel inventory;
    private JTextField healthTextField;
    private JTextField armorClassTextField;
    private JTextField speedTextField;
    private JLabel hp;
    private JLabel ac;
    private JLabel speed;
    private JComboBox inventoryComboBox;
    private JLabel weapon;
    private JComboBox weaponsComboBox;
    private JLabel feats;
    private JComboBox featsComboBox;
    private JLabel initiative;
    private JTextField initiativeTextField;
    private JTextArea notesTextArea;
    private JButton save;
    private JButton load;
    private JButton addItemButton;
    private JButton addWeaponButton;
    private JButton addFeatButton;
    private JComboBox spellsComboBox;
    private JButton removeItemButton;
    private JButton removeWeaponButton;
    private JButton removeFeatButton;
    private JButton removeSpellButton;
    private JButton addSpellButton;

    //initializes the DnD feature
    //adds action lisenters to the buttons on the frame
    public DnD()
    {
        save.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                save();
            }
        });

        load.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                load();
            }
        });

        addItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addItem();
            }
        });

        removeItemButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeItem();
            }
        });

        addWeaponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addWeapon();
            }
        });

        removeWeaponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeWeapon();
            }
        });
        addFeatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFeat();
            }
        });

        removeFeatButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeFeat();
            }
        });

        addSpellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addSpell();
            }
        });
        removeSpellButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                removeSpell();
            }
        });
    }

    //sets the Frame to be displayed
    public void setBoard() {

        JFrame frame = new JFrame("App");
        frame.setContentPane(new DnD().player);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    //handles saving a DnD Character
    //name of save file should be the name of the Character
    public void save()
    {
        File saveFile = new File(playerNameTextField.getText() != null ? playerNameTextField.getText() + ".txt" : "newPlayer.txt");
        saveFile.canWrite();

        BufferedWriter buffWriter = null;
        FileWriter fileWriter = null;


        String inventory = "";
        String weapons = "";
        String feats = "";
        String spells = "";

        for(int i = 0; i < inventoryComboBox.getItemCount(); i++)
        {
            inventory = inventory +  inventoryComboBox.getItemAt(i) + "/";
        }

        for(int i = 0; i < weaponsComboBox.getItemCount();i++)
        {
            weapons = weapons + weaponsComboBox.getItemAt(i) + "/";
        }

        for(int i = 0; i < featsComboBox.getItemCount();i++)
        {
            feats = feats + featsComboBox.getItemAt(i) + "/";
        }
        for(int i = 0; i < spellsComboBox.getItemCount();i++)
        {
            spells = spells + spellsComboBox.getItemAt(i) + "/";
        }

        ArrayList<String> characterProfile = new ArrayList<String>();
        characterProfile.add(playerNameTextField.getText());
        characterProfile.add(raceTextField.getText());
        characterProfile.add(experienceTextField.getText());
        characterProfile.add(healthTextField.getText());
        characterProfile.add(classLevelTextField.getText());
        characterProfile.add(alignmentTextField.getText());
        characterProfile.add(armorClassTextField.getText());
        characterProfile.add(speedTextField.getText());
        characterProfile.add(strengthTextField.getText());
        characterProfile.add(dexterityTextField.getText());
        characterProfile.add(constitutionTextField.getText());
        characterProfile.add(intelligenceTextField.getText());
        characterProfile.add(wisdomTextField.getText());
        characterProfile.add(charismaTextField.getText());
        characterProfile.add(initiativeTextField.getText());
        characterProfile.add(notesTextArea.getText());
        characterProfile.add(inventory);
        characterProfile.add(weapons);
        characterProfile.add(feats);
        characterProfile.add(spells);

        try
        {
           fileWriter = new FileWriter((saveFile.getName()));
           buffWriter = new BufferedWriter(fileWriter);

            for(String item : characterProfile)
            {
                buffWriter.write(item);
                buffWriter.newLine();
            }

            buffWriter.close();
            fileWriter.close();
        }
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(null,"save file does not exist");
        }
    }

    //loads in a  DnD Character
    //DOES NOT WORK IF CHARACTER STATS ARE NOT IN THE CORRECT FORMAT
    public void load()
    {
        clearFields();
        String inputFileName = JOptionPane.showInputDialog("Please enter the name of the character to load.");
        String inputLine = null;
        File inputFile = new File(inputFileName + ".txt");
        FileReader fileReader = null;
        BufferedReader buffReader = null;

        ArrayList<String> inputData = new ArrayList<String>();

        try
        {
            fileReader = new FileReader(inputFile);
            buffReader = new BufferedReader(fileReader);

            while((inputLine = buffReader.readLine()) != null)
            {
                inputData.add(inputLine);
            }

            buffReader.close();
            fileReader.close();;
        }
        catch(IOException e)
        {
            JOptionPane.showMessageDialog(null, "File Does Not Exist!");
        }

        String inventory[] = inputData.get(inputData.size()-4).split("/");;
        String weapons[] = inputData.get(inputData.size()-3).split("/");;
        String feats[] = inputData.get(inputData.size()-2).split("/");
        String spells[] = inputData.get(inputData.size()-1).split("/");

        playerNameTextField.setText(inputData.get(0));
        raceTextField.setText(inputData.get(1));
        experienceTextField.setText(inputData.get(2));
        healthTextField.setText(inputData.get(3));
        classLevelTextField.setText(inputData.get(4));
        alignmentTextField.setText(inputData.get(5));
        armorClassTextField.setText(inputData.get(6));
        speedTextField.setText(inputData.get(7));
        strengthTextField.setText(inputData.get(8));
        dexterityTextField.setText(inputData.get(9));
        constitutionTextField.setText(inputData.get(10));
        intelligenceTextField.setText(inputData.get(11));
        wisdomTextField.setText(inputData.get(12));
        charismaTextField.setText(inputData.get(13));
        initiativeTextField.setText(inputData.get(14));
        notesTextArea.setText(inputData.get(15));

        for(int i = 0; i < inventory.length;i++)
        {
            inventoryComboBox.addItem(inventory[i]);
        }
        for(int i = 0; i < weapons.length; i++)
        {
            weaponsComboBox.addItem(weapons[i]);
        }
        for(int i = 0; i < feats.length; i++)
        {
            featsComboBox.addItem(feats[i]);
        }
        for(int i = 0; i < spells.length;i++)
        {
            spellsComboBox.addItem(spells[i]);
        }
    }

    //adds an item to the character's inventory
    public void addItem()
    {
        String item = JOptionPane.showInputDialog("Please enter the Item you want to add");
        inventoryComboBox.addItem(item);
    }

    //removes an Item
    public void removeItem()
    {
        String item = JOptionPane.showInputDialog("What Item do you want to remove?");
        inventoryComboBox.removeItem(item);
    }

    //adds a weapon to the character
    public void addWeapon()
    {
        String item = JOptionPane.showInputDialog("Please enter the weapon you want to add");
        weaponsComboBox.addItem(item);
    }

    //removes a weapon
    public void removeWeapon()
    {
        String item = JOptionPane.showInputDialog("What weapon do you want to remove?");
        weaponsComboBox.removeItem(item);
    }

    //adds a feat to the characters
    public void addFeat()
    {
        String feat = JOptionPane.showInputDialog("Please enter the feat you want to add");
        featsComboBox.addItem(feat);
    }

    public void removeFeat()
    {
        String item = JOptionPane.showInputDialog("What feat do you want to remove?");
        featsComboBox.removeItem(item);
    }

    //adds a spell to the player
    public void addSpell()
    {
        String item = JOptionPane.showInputDialog("Please input a spell to add");
        spellsComboBox.addItem(item);
    }

    //removes a spell
    public void removeSpell()
    {
        String item = JOptionPane.showInputDialog("What spell do you want to remove?");
        spellsComboBox.removeItem(item);
    }

    //resets all of the fields to blank
    //used when loading a new character
    public void clearFields()
    {
        playerNameTextField.setText("");
        raceTextField.setText("");
        experienceTextField.setText("");
        healthTextField.setText("");
        classLevelTextField.setText("");
        alignmentTextField.setText("");
        armorClassTextField.setText("");
        speedTextField.setText("");
        strengthTextField.setText("");
        dexterityTextField.setText("");
        constitutionTextField.setText("");
        intelligenceTextField.setText("");
        wisdomTextField.setText("");
        charismaTextField.setText("");
        initiativeTextField.setText("");
        notesTextArea.setText("");
        inventoryComboBox.removeAllItems();
        weaponsComboBox.removeAllItems();
        featsComboBox.removeAllItems();
        spellsComboBox.removeAllItems();
    }

}
