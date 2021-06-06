

export class Receta{
    id: number;
    name: string;
    description: string;
    rate: number;
    difficulty: number;
    timeTaken: number;
    steps: string;
    ingredients: string;
    image: string;
    
    constructor(){
        this.id = 0;
        this.name = '';
        this.description = '';
        this.rate = 0;
        this.difficulty = 0;
        this.timeTaken = 0;
        this.steps = '';
        this.ingredients = '';
        this.image = '';
        
    }
}