import { Component, OnInit, OnDestroy } from '@angular/core';
import { TasksService } from './tasks.service';
import { Task } from './task';
import { Observable, Subscription } from 'rxjs/Rx';

@Component({
  selector: 'gtd-tasks',
  templateUrl: 'tasks.component.html',
  styles: [`
   .add-box {
     margin: 5px auto;
   }

   .bm-20 {
     margin-bottom: 20px;
   }

   h2 {
     padding: .5rem .75rem;
   }
  `]
})
export class TasksComponent implements OnInit, OnDestroy {

  desc = '';
  openTasks: Task[];
  closedTasks: Task[];

  subTasks$: Subscription;
  title: String = 'Usable GTD';

  constructor(private service: TasksService) { }

  ngOnInit() {
    this.setTasks();
  }

  ngOnDestroy() {
    this.subTasks$.unsubscribe()
  }

  setTasks(): void {
     this.subTasks$ = this.service.pendingTasks()
       .subscribe(
         tasks => {
           this.openTasks = tasks.filter(t => t.state === 'TODO');
           this.closedTasks = tasks.filter(t => t.state === 'COMPLETED');
         }
       );
  }

  onAdd(): void {
    console.log(`Add new task: ${this.desc}`);
    this.service.addTask(this.createTask())
      .subscribe(
      r => this.onSuccess(),
      e => console.error(e)
      );
  }

  onDelete(id: number): void {
    console.log(`Delete task: ${id}`);
    this.service.deleteTask(id)
      .subscribe(
      r => this.onSuccess(),
      e => console.error(e)
      );
  }

  onComplete(id: number): void {
    console.log(`Complete task: ${id}`);
    this.service.closeTask(id)
      .subscribe(
      r => this.onSuccess(),
      e => console.error(e)
      );
  }

  private createTask(): Task {
    return {
      id: null,
      description: this.desc.length > 50 ? this.desc.substring(0, 49) : this.desc,
      createdAt: null,
      completedAt: null,
      state: null
    };
  }

  isEmpty(): boolean {
    return this.desc === '';
  }

  private onSuccess(): void {
    this.desc = '';
    this.setTasks();
  }
}
