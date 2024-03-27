import java.util.ArrayList;
public class Folder
{
    private String name;
    private ArrayList<File> files;
    private ArrayList<Folder> folder;

    public Folder(String name, ArrayList<File> files, ArrayList<Folder> folder)
    {
        this.name = name;
        this.files = files;
        this.folder = folder;
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<File> getFiles()
    {
        return files;
    }

    public ArrayList<Folder> getFolder()
    {
        return folder;
    }
}