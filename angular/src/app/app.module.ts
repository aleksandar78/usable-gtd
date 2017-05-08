import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { AppComponent } from './app.component';
import { TasksComponent } from './tasks/tasks.component';
import { TaskPendingComponent } from './tasks/task-pending.component';

import { TasksService } from './tasks/tasks.service';
import { TaskCompletedComponent } from './tasks/task-completed.component';

@NgModule({
  declarations: [
    AppComponent,
    TasksComponent,
    TaskPendingComponent,
    TaskCompletedComponent
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
