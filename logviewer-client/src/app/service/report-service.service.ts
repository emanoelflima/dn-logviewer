import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { environment } from './../../environments/environment';

const HTTP_OPTIONS: Object = {
  responseType: 'text'
}

@Injectable({
  providedIn: 'root'
})
/**
 * Service for Report data
 * @author Emanoel de Lima
 */
export class ReportService {

  constructor(private http: HttpClient) { }
  
  /**
   * Sends log file and retrieves processed report data
   * @param file the log file to be submitted
   * @returns report data in string xml data
   */
  public generateReport(file: File): Observable<string> {

    let formData = new FormData();
    formData.append('file', file);

    return this.http.post<string>(`${environment.URL_REPORT_API}/generate`, formData, HTTP_OPTIONS);
  }

}
