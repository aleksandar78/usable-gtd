import { Observable } from 'rxjs/Rx';
import 'rxjs/add/operator/map';
import 'rxjs/add/operator/catch';
import { Injectable } from '@angular/core';
import { Task } from './task';
import { Http } from '@angular/http';
import { environment } from '../../environments/environment';

@Injectable()
export class TasksService {

  constructor(private http: Http) { }

  pendingTasks(): Observable<Task[]> {
    return this.http.get(`${environment.endpointUrl}/tasks`)
      .map(res => res.json())
      .catch(err => Observable.throw(err || 'Task endpoint service unavailable'));
  }

  addTask(task: Task): Observable<void> {
    return this.http.post(`${environment.endpointUrl}/tasks`, task)
      .map(res => {
        if ( res.status !== 201 ) {
          return Observable.throw(res.json().error);
        }
      })
      .catch(err => Observable.throw(err || 'Task endpoint service unavailable'));
  }

  closeTask(id: number): Observable<void> {
    return this.http.put(`${environment.endpointUrl}/tasks/${id}`, null)
      .map(res => {
        if (res.status !== 204) {
          return Observable.throw(res.json().error);
        }
      })
      .catch(err => Observable.throw(err || 'Task endpoint service unavailable'));
  }

  deleteTask(id: number): Observable<void> {
    return this.http.delete(`${environment.endpointUrl}/tasks/${id}`)
      .map(res => {
        if (res.status !== 204) {
          return Observable.throw(res.json().error);
        }
      })
      .catch(err => Observable.throw(err || 'Task endpoint service unavailable'));
  }

}
