# Puggle: MediaWiki editing in IntelliJ IDEA

## What's new - Version 0.13a
* Added the following quickfixes to inline external links..
  * Convert to reference
  * Move to external links section (create if not exist)
  * Remove
  
## Installing Puggle
### From source
1. Set up an IntelliJ plugin development environment as per here: http://www.jetbrains.org/intellij/sdk/docs/basics/getting_started/setting_up_environment.html
2. Clone this project somewhere and open it in IntelliJ IDEA.
3. Set the project SDK to be the plugin development SDK that you set up earlier.
4. Run the project's "Plugin" run configuration.

### Using a binary release
1. Download the [latest release](https://github.com/drewmutt/puggle/releases).
2. In IntelliJ, go to Settings > Plugins > Install plugin from disk.
3. Find where you saved the plugin (.zip file) and restart IntelliJ when prompted.
4. Create a new empty IntelliJ project (specialized MediaWiki project coming soon).
5. Create a file with the `.mediawiki` extension, and add some wikitext.

## Contact us
If you have any questions, bugs, or freature requests, you can join us on IRC at ##puggle on Freenode! (All IRC users with a `@wikipedia` or `@wikimedia` host-mask are automatically voiced.)
