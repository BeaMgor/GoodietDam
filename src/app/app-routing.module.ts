import { DetalleComponent } from './pages/detalle/detalle.component';
import { LoginComponent } from './pages/login/login.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { RegistroComponent } from './pages/registro/registro.component';
import { RecetasComponent } from './pages/recetas/recetas.component';
import { TerminosComponent } from './pages/terminos/terminos.component';
import { UsuarioComponent } from './pages/usuario/usuario.component';
import { HomeComponent } from './pages/home/home.component';

const routes: Routes = [
  {
    path: '',
    redirectTo: 'home',
    pathMatch: 'full'
  },

  {
    path: 'home',
    component: HomeComponent
  },
  
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'registro',
    component: RegistroComponent      
    
  },
  {
    path: 'recetas',
    component: RecetasComponent
  },

  {
    path: 'terminos',
    component: TerminosComponent
  },

  {
    path: 'usuario',
    component: UsuarioComponent
  },
  {
    path: 'detalle',
    component: DetalleComponent
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }