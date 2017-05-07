import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { TasksComponent } from './tasks/tasks.component';
import { TaskComponent } from './tasks/task.component';

import { TasksService } from './tasks/tasks.service';

@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    TaskComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule
  ],
  providers: [TasksService],
  bootstrap: [AppComponent]
})
export class AppModule { }
