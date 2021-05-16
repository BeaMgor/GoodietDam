import { LoginComponent } from './pages/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistroComponent } from './pages/registro/registro.component';
import { RecetasComponent } from './pages/recetas/recetas.component';
import { DetalleComponent } from './pages/detalle/detalle.component';


const routes: Routes = [
  {
    path: '',
    redirectTo: 'login',
    pathMatch: 'full'
  },
  
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'register',
    component: RegistroComponent      
    
  },
  {
    path: 'recetas',
    component: RecetasComponent
  },

  {
    path: 'detalle',
    component: DetalleComponent
  }
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
