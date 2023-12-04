public class Main
{
    public static void main(String[] args)
    {
        Menu menu = new Menu(5);
        menu.add("Add a new person");
        menu.add("Remove a person");
        menu.add("Update a person");
        menu.add("Show list");
        menu.add("Quit");
        
        int choice;
        PersonList list = new PersonList(50);
        
        do
        {
            System.out.println("SYSTEM MANAGER");
            choice = menu.getChoice();
            switch (choice)
            {
                case 1:
                    list.add();
                    break;
                case 2:
                    list.remove();
                    break;
                case 3:
                    list.update();
                    break;
                case 4:
                    list.sort();
                    list.print();
                    break;
                case 5:
                    System.out.println("Thanks for using. See you next time.");
                    break;
                default:
                    System.out.println("Try again");
                    break;
            }
        }
        while (choice != 5);
    }
}
