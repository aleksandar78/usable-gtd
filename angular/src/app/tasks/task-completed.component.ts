import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Task } from './task';

@Component({
  selector: 'gtd-task-completed',
  template: `
    <div class="row">
      <div class="col-10 desc-text">{{ task.description }}</div>
       <div class="col-2">
        <button class="btn btn-sm btn-block btn-secondary" style="width:100%; height:100%;" (click)="taskDelete.emit(task.id)">
          <i class="fa fa-trash" aria-hidden="true"></i>
        </button>
      </div>
      </div>
  `,
  styles: [`
    div.row:hover {
      background-color: #eee;
    }

    .desc-text {
      font-style: italic;
    }
  `]
})
export class TaskCompletedComponent implements OnInit {

  @Input() task: Task;
  @Output() taskDelete = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
  }

}
