import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Task } from './task';

@Component({
  selector: 'gtd-task',
  template: `
      <div class="row">
      <div class="col-8">{{ task.description }}</div>
      <div class="col-2">
        <button class="btn btn-sm btn-block btn-success" style="width:100%; height:100%;" (click)="onComplete()">
          <i class="fa fa-check" aria-hidden="true"></i>
        </button>
      </div>
       <div class="col-2">
        <button class="btn btn-sm btn-block btn-danger" style="width:100%; height:100%;" (click)="onDelete()">
          <i class="fa fa-trash" aria-hidden="true"></i>
        </button>
      </div>
      </div>
  `,
  styles: [`
      .row {
        border-top: 1px solid #eee;
        border-bottom: 1px solid #eee;
        margin: 2px auto;
      }
  `]
})
export class TaskComponent implements OnInit {

  @Input() task: Task;
  @Output() completeEmitter = new EventEmitter<number>();
  @Output() deleteEmitter = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
  }

  onComplete(): void {
    this.completeEmitter.emit(this.task.id);
  }

  onDelete(): void {
    this.deleteEmitter.emit(this.task.id);
  }
}
