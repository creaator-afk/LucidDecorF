import { Component, Input } from '@angular/core';

interface Video {
  id: string;
  title: string;
  description: string;
  duration: number;
  uploadDate: Date;
  views: number;
  likes: number;
  dislikes: number;
  url: string;
  thumbnailUrl: string;
}

@Component({
  selector: 'app-video-player',
  templateUrl: './video-player.component.html',
  styleUrls: ['./video-player.component.sass']
})
export class VideoPlayerComponent {
  @Input() video!: Video;
}
