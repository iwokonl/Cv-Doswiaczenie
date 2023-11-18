from pytube import Playlist
import os
from moviepy.editor import AudioFileClip

p = Playlist('https://www.youtube.com/playlist?list=PLG0JSfWdoT3OSNkZaJcdTtseY2JGoTxpn')

print(f'Downloading: {p.title}')

for video in p.videos:
    print(video.title)
    st = video.streams.get_audio_only()
    out_file = st.download()
    base, ext = os.path.splitext(out_file)
    new_file = base + '.mp3'

    # Convert mp4 audio to mp3
    clip = AudioFileClip(out_file)
    clip.write_audiofile(new_file)

    # Remove the original mp4 audio file
    os.remove(out_file)