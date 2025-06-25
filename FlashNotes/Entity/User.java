package Entity;

import InterFace.IUserOperations;

public class User implements IUserOperations 
{
    private String name;
    private String id;
    private MyNote[] notes;

    public User() {
        notes = new MyNote[20];
    }

    public User(String name, String id) 
	{
        this.name = name;
        this.id = id;
        notes = new MyNote[20];
    }

    public String getName() 
	{
        return name;
    }

    public void setName(String name) 
	{
        this.name = name;
    }

    public String getId() 
	{
        return id;
    }

    public void setId(String id) 
	{
        this.id = id;
    }


    public void addNote(MyNote note) 
	{
        for (int i = 0; i < notes.length; i++) 
		{
            if (notes[i] == null) 
			{
                notes[i] = note;
                return;
            }
        }
    }
}