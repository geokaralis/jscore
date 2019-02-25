package jscore.android.parse

class Parser {
    private var parse: Parse? = null

    fun <T> parsed(params: ArrayList<T>): Boolean {
        return true
    }

    fun <T> parse(params: ArrayList<T>): String {
        val paramsBuilder = StringBuilder()
        var methodParams: String? = null
        var param: String?
        val size: Int? = params.size

        params.forEachIndexed { index, el ->
            param = "$el"
            if (el is String) param = "'$el'"
            if (el is ArrayList<*>) {
                param = param?.replace("[,| ]".toRegex(), "")

                param = param!!.replace("([a-zA-Z._^%\$#!~@,-]+)".toRegex(), "'\$1',")

                param = param!!.replace("(\\d(?=\\d{1}))".toRegex(), "\$1, ")
            }

            param = "$param, "

            if (index == size!! - 1)
            {
                param = param!!.replace(
                    "[,| ]".toRegex(),
                    ""
                )
            }

            methodParams = paramsBuilder.append(param).toString()
        }

        return "$methodParams"
    }
}