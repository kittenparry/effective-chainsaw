public class Locales {
    private String lang = "EN";
    public String super_label, dir, file, entry, button, error, log1, log2;
    public void Strings(){
        if(lang.equals("EN")){
            super_label = "Log Recorder";
            dir = "Directory:";
            file = "Filename:";
            entry = "Entry:";
            button = "Enter";
            error = "|| Error: Folder doesn't exist.";
            log1 = "|| Entry logged..";
            log2 = "|| Entry logged.";
        }
    }
}
