import java.util.ArrayList;
public class Main
{
    public static void main(String[] args)
    {
        ArrayList<File> imageFiles = new ArrayList<File>();
        imageFiles.add(new File("background.jpg"));
        imageFiles.add(new File("logo.jpg"));

        ArrayList<Folder> imageFolder = new ArrayList<Folder>();
        Folder image = new Folder("images", imageFiles, imageFolder);

        ArrayList<File> filesSrc = new ArrayList<File>();
        filesSrc.add(new File("Main.cpp"));
        filesSrc.add(new File("Maze.cpp"));
        filesSrc.add(new File("Solver.cpp"));
        filesSrc.add(new File("Das.cpp"));

        ArrayList<File> tileFiles = new ArrayList<File>();
        tileFiles.add(new File("Turn.cpp"));
        tileFiles.add(new File("Straight.cpp"));

        ArrayList<Folder> tileFolder = new ArrayList<Folder>();
        Folder tile = new Folder("tile",tileFiles,tileFolder);

        ArrayList<Folder> srcFolder = new ArrayList<Folder>();
        srcFolder.add(tile);
        Folder src = new Folder("src",filesSrc,srcFolder);

        ArrayList<File> adminFiles = new ArrayList<File>();
        adminFiles.add(new File("settings.cfg"));
        adminFiles.add(new File("override.txt"));

        ArrayList<File> userFiles = new ArrayList<File>();
        userFiles.add(new File("user1.data"));
        userFiles.add(new File("user2.data"));
        userFiles.add(new File("user3.data"));
        userFiles.add(new File("user4.data"));

        ArrayList<Folder> adminFolder = new ArrayList<Folder>();
        ArrayList<Folder> userFolder = new ArrayList<Folder>();
        Folder userData  = new Folder("user_data",userFiles,userFolder);
        Folder adminData = new Folder("admin_data",adminFiles,adminFolder);

        ArrayList<Folder> dataFolder = new ArrayList<Folder>();
        dataFolder.add(userData);
        dataFolder.add(adminData);

        ArrayList<File> dataFiles = new ArrayList<File>();
        dataFiles.add(new File("password.txt"));
        dataFiles.add(new File("username.txt"));
        Folder data = new Folder("data",dataFiles,dataFolder);
        ArrayList<Folder> websiteFolder = new ArrayList<Folder>();

        websiteFolder.add(src);
        websiteFolder.add(data);
        websiteFolder.add(image);
        ArrayList<File> websiteFile = new ArrayList<File>();
        Folder website = new Folder("website",websiteFile,websiteFolder);

        System.out.println(getNumberOfFiles(website));
        System.out.println(getNumberOfFilesNoRecursion(website));
    }

    public static int getNumberOfFiles(Folder f)
    {
        int count = f.getFiles().size();
        for(Folder subFolder : f.getFolder())
        {
            count += getNumberOfFiles(subFolder);
        }
        return count;
    }

    public static int getNumberOfFilesNoRecursion(Folder f)
    {
        int numberOfFiles = 0;
        ArrayList<Folder> foldersToCheck = new ArrayList<Folder>();
        foldersToCheck.add(f);
        while(foldersToCheck.size() != 0)
        {
            Folder currentFolder = foldersToCheck.get(0);
            numberOfFiles += currentFolder.getFiles().size();
            for(Folder subfolder : currentFolder.getFolder())
            {
                foldersToCheck.add(subfolder);
            }
            foldersToCheck.remove(0);
        }
        return numberOfFiles;
    }
}