// src/app/video.service.ts
import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Video } from './video.model';

@Injectable({
  providedIn: 'root'
})
export class VideoService {
  private baseUrl = 'http://localhost:8080/videos';

  constructor(private http: HttpClient) { }

  getAllVideos(): Observable<Video[]> {
    return this.http.get<Video[]>(this.baseUrl);
  }

  getVideoById(id: number): Observable<Video> {
    return this.http.get<Video>(`${this.baseUrl}/${id}`);
  }

  createVideo(video: Video): Observable<Video> {
    return this.http.post<Video>(this.baseUrl, video);
  }

  deleteVideo(id: number): Observable<void> {
    return this.http.delete<void>(`${this.baseUrl}/${id}`);
  }
}
