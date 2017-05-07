import { Observable } from 'rxjs/Observable';
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
      .catch(err => Observable.throw(err.json().error || 'Task endpoint service unavailable'));
  }

}
