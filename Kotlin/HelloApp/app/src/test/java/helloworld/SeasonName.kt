package helloworld
//通过构造函数能够给枚举值赋予更加丰富的含义
//ordinal属性用于获取该枚举值的序号，name属性用于获取该枚举值的名称。
enum class SeasonName(val seasonName: String) {
    SPRING("春天"),
    SUMMER("夏天"),
    AUTUMN("秋天"),
    WINTER("冬天")
}