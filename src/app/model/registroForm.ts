// nos cremaos una clase para recoger datos del formulario y mandarlos y creamos el constructor directamente para
// declarar las variables y que luego no nos de error.

// tslint:disable-next-line: class-name
export class registroForm {
    public username!: string;
    public surname!: string;
    public password!: string;
    public password2!: string;
    public phone!: string;
    public province!: string;
    public location!: string;
    public direction!: string;
    public email!: string;
    public acept!: boolean;



    constructor(){
        this.username = '';
        this.surname = '';
        this.password = '';
        this.password2 = '';
        this.phone = '';
        this.province = '';
        this.location = '';
        this.direction = '';
        this.email = '';
        this.acept = false;
    }
}