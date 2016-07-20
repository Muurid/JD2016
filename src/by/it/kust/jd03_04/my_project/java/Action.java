package by.it.kust.jd03_04.my_project.java;


enum Action {
    SIGNUP {
        {
            this.command = new CommandSignUp();
            this.inPage="/signup.jsp";
            this.okPage ="/login.jsp";
        }
    },
    LOGIN {
        {
            this.command = new CommandLogin();
            this.inPage="/login.jsp";
            this.okPage ="/index.jsp";
        }
    },
    LOGOUT {
        {
            this.command = new CommandLogout();
            this.inPage="/logout.jsp";
            this.okPage ="/index.jsp";
        }
    },
    ERROR {
        {
            this.command = new CommandError();
            this.inPage="/error.jsp";
            this.okPage="/error.jsp";
        }
    },
    PROFILE {
        {
            this.command = new CommandProfile();
            this.inPage="/profile.jsp";
            this.okPage ="/login.jsp";
        }
    },
    ORDERTOUR {
        {
            this.command = new CommandAddTour();
            this.inPage="/ordertour.jsp";
            this.okPage ="/deletetour.jsp";
        }
    },
    DELETETOUR {
        {
            this.command = new CommandDeleteTour();
            this.inPage="/profile.jsp";
            this.okPage ="/ordertour.jsp";
        }
    },
    ALLUSERS {
        {
           this.command  = new CommandAllUsers();
            this.inPage="/allusers.jsp";
            this.okPage="/allusers.jsp";
        }
    },
    INDEX {
        {
            this.command = new CommandIndex();
            this.inPage="/index.jsp";
            this.okPage ="/index.jsp";
        }
    };
    //инициализация полей по умолчанию
    protected ActionCommand command = new CommandLogin();
    public String inPage="/login.jsp";
    public String okPage ="/login.jsp";
    public ActionCommand getCurrentCommand() {
        return command;
    }
    public static final String msgError="msg_error";
    public static final String msgMessage="message";
}