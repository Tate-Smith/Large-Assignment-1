# Large-Assignment-1
search for information from the music store
  for a song by title
  for a song by artist
  for an album by title
  for an album by artist
the expected results of searching
  for a song that is in the database: print the song title, the artist, and the album it’s on
  for an album: print the album information and a list of the songs in the appropriate order
  for anything that is not in the database: a message indicating that the item is not there
  for anything that has multiple results: print all the results
search for information from the user library
  should cover all the search cases listed for the music store
  should also be able to search for a playlist by name – the result should print the songs (title and artist)
add something to the library
  add a song to the library (as long as it is in the store)
  add a whole album to the library (as long as it is in the store)
  get a list of items from the library
  a list of song titles (any order)
  a list of artists (any order)
  a list of albums (any order)
  a list of playlists (any order)
  a list of “favorite” songs
create a playlist and add/remove songs
playlists should have a name
songs should be maintained in the order they are added
mark a song as “favorite”
rate a song
  the ratings are 1 to 5
  songs do not have to be rated so there is no default rating
  songs that are rated as 5 should automatically be set to “favorite”
Additional Requirements
  Even though I’m not so concerned about the code design in the View, you do need to think carefully about designing the UI.
  It needs to be user-friendly (as far as is possible with a text-based system), so make sure you test it thoroughly.
Here are some examples of bad design that you should avoid:
  requiring long inputs for commands or long input sequences (i.e. don’t make the user verify that their command was in fact what they wanted)
  not handling invalid input – (i.e. make sure that if something is typed incorrectly, the user can just retype it; do not make it end the program!)
