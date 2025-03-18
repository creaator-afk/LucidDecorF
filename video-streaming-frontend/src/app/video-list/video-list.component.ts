// src/app/video-list/video-list.component.ts
import { Component, OnInit } from '@angular/core';
import { VideoService } from '../video.service';
import { Video } from '../video.model';

@Component({
  selector: 'app-video-list',
  templateUrl: './video-list.component.html',
  styleUrls: ['./video-list.component.css']
})
export class VideoListComponent implements OnInit {
  videos: Video[] = [];

  constructor(private videoService: VideoService) { }

  ngOnInit(): void {
    this.videoService.getAllVideos().subscribe(data => {
      this.videos = data;
    });
  }
}
