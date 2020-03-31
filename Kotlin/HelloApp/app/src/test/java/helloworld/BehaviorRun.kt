package helloworld

class BehaviorRun : Behavior {
    override fun fly(): String {
        return "fly"
    }

    override fun swim(): String {
        return "swim"
    }

    override var skilledSports: String="fly"
}