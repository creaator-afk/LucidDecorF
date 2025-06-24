export interface Video {
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
