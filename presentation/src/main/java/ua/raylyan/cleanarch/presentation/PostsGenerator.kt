package ua.raylyan.cleanarch.presentation

import ua.raylyan.cleanarch.domain.contract.entity.Post


class PostsGenerator {

    private val titles = listOf(
            "LLLLHL LLFLIFHFIF LFLKFL",
            "VSVVVSVSVSVV SVVSVSV",
            "EEWEEWEEW EEWEEEWEEEWW",
            "NNNNOOOOO OOOOONNNN",
            "SASASASSA DSDDSDSSDS",
            "PLPLPLP KLKLKLKLKLKL")

    private val bodies = listOf(
            "fjdsbfjkjdfbjsdbfbdbfbf hd sadja kns;knf;k lkdawksdn",
            "jbdjksbfjbsjdbfjbsjfbjdbjbfljsd  bdabwkdjblasbd",
            "jdbflblsbflbslflsd  jba dlbaslb l l  bldan alsn ;d ",
            "jdbasnd asb dlsab ln' asb d'sbd lsjl bajs bdljb aslb jlasb",
            "jbsalbdlas k;n;kdnsan dsn ;knclsklcbaj sbjd lk nklsand",
            "kdnf;nas klnlcn sld sl dnsal ldjs ljs lsl lk b as",
            "adb'sbldb sb dbs balb dlab 'dbasl'b 'b s'abd 'lbas'l bsb ls'anlnskn",
            "ldkslcasl las ld iad 'lasj 'dj as j ns j;j s;'"
    )


    fun generateDemoData() : List<Post>{
         val posts = mutableListOf<Post>()

        for (i in 0 until 20){
            var title = titles.getRandomElement()
            var body = bodies.getRandomElement()
            posts.add(Post(0,i + 1L, title, body))
        }

        return posts
    }

}