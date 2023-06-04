import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppComponent } from './app.component';

import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';

import { AppRoutingModule } from './app-routing.module';
import { AddUserComponent } from './components/add-user/add-user.component';
import { UserDetailComponent } from './components/user-detail/user-detail.component';
import { UsersListComponent } from './components/users-list/users-list.component';
import { IncluirFuncionarioComponent } from './funcionario/incluir-funcionario/incluir-funcionario.component';
import { EditarFuncionarioComponent } from './funcionario/editar-funcionario/editar-funcionario.component';
import { ListarFuncionarioComponent } from './funcionario/listar-funcionario/listar-funcionario.component';
import { DeletarFuncionarioComponent } from './funcionario/deletar-funcionario/deletar-funcionario.component';
import { MatSlideToggleModule } from '@angular/material/slide-toggle';

@NgModule({
  declarations: [
    AppComponent,
    AddUserComponent,
    UserDetailComponent,
    UsersListComponent,
    IncluirFuncionarioComponent,
    EditarFuncionarioComponent,
    ListarFuncionarioComponent,
    DeletarFuncionarioComponent,
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule,
    AppRoutingModule,
    MatSlideToggleModule,
  ],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
