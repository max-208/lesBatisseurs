package controller;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * actionlistener spécifique au menus
 */
public class MenuListener implements ActionListener{
    /**
     * le gamelauncher
     */
    GameLauncher gl;
    /**
     * l'action en cours
     */
    String currentAction;
    /**
     * le constructeur de MenuListener
     * @param gl le gamelauncher
     */
    MenuListener(GameLauncher gl){
        this.gl = gl;
        this.currentAction = "";
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "back":
                this.gl.visualInterface.menu();
                this.currentAction = "";
                break;
            case "nouvelle":
                this.gl.visualInterface.saveSelect();
                this.currentAction = "N";
                break;
            case "charger":
                this.gl.visualInterface.saveSelect();
                this.currentAction = "C";
                break;
            case "regles":
                this.gl.visualInterface.regles();
                break;
        
            default:
                int num = Integer.parseInt(e.getActionCommand());
                switch (this.currentAction) {
                    case "N":
                        this.gl.savefile = num;
                        this.gl.loadConf();
                        this.gl.launchGame(false);
                        break;
                    case "C":
                        this.gl.savefile = num;
                        this.gl.loadSave();
                        this.gl.launchGame(false);
                        break;
                }
                break;
        }
    }
    
}
