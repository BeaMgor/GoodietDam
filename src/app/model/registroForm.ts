// nos cremaos una clase para recoger datos del formulario y mandarlos y creamos el constructor directamente para
// declarar las variables y que luego no nos de error.

// tslint:disable-next-line: class-name
export class registroForm {
    public username!: string;
    public password!: string;
    public password2!: string;
    public email!: string;
   



    constructor(){
        this.username = '';
        this.password = '';
        this.password2 = '';
        this.email = '';
    }
}