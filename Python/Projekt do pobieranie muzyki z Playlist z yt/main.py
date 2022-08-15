
import moviepy
from pytube import Playlist
import os

p = Playlist('https://www.youtube.com/playlist?list=PLG0JSfWdoT3P-1tIQIapZEJQAYqyLxRO5')

print(f'Downloading: {p.title}')

for video in p.videos:
    print(video.title)
    st = video.streams.get_audio_only()
    out_file = st.download()
    base, ext = os.path.splitext(out_file)
    new_file = base + '.mp3'
    os.rename(out_file, new_file)
    #video.streams.first().download()