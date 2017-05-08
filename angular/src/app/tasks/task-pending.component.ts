import { Component, OnInit, Input, Output, EventEmitter } from '@angular/core';
import { Task } from './task';

@Component({
  selector: 'gtd-task-pending',
  template: `
      <div class="row">
      <div class="col-10">{{ task.description }}</div>
      <div class="col-2">
        <button class="btn btn-sm btn-block btn-outline-success" style="width:100%; height:100%;" (click)="taskComplete.emit(task.id)">
          <i class="fa fa-check" aria-hidden="true"></i>
        </button>
      </div>
      </div>
  `,
  styles: [`
      div.row {
        font-weight: bold;
      }

      dev.row:hover {
        background-color: #eee;
      }
  `]
})
export class TaskPendingComponent implements OnInit {

  @Input() task: Task;
  @Output() taskComplete = new EventEmitter<number>();

  constructor() { }

  ngOnInit() {
  }

}
