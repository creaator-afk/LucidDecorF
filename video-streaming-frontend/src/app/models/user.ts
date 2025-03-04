export interface User {
  id: string;
  username: string;
  email: string;
  profilePictureUrl: string;
  subscriptionStatus: 'FREE' | 'PREMIUM';
  watchHistory: Video[];
  likedVideos: Video[];
  dislikedVideos: Video[];
}
