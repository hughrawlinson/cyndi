# spotify-client

Print the tracks from a Cyndi Lauper album

## Usage
Make sure environmental variables called `SPOTIFY_CLIENT_ID` and `SPOTIFY_SECRET_TOKEN` are available to the process containing your Spotify client credentials. I do this by putting them in a file called `env` in the format `KEY=VALUE`, ending in a newline. Make sure not to commit your client secret!

    $ lein run
