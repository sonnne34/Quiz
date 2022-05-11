package com.template

object DataQuestions {
    fun getDataQuestions(): ArrayList<DataQuestionModel> {

        val questionsDataList = ArrayList<DataQuestionModel>()

        val question1 = DataQuestionModel(
//            id номер вопроса:
            1,
//            номер правильного ответа:
            2,
//            вопрос:
            "ЗАМЕНИТЬ_ВОПРОС_1",
//            ответ 1:
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
//            ответ 2:
            "ПРАВИЛЬНЫЙ_ОТВЕТ",
//            ответ 3:
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
//            ответ 4:
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ"
        )
        questionsDataList.add(question1)

        val question2 = DataQuestionModel(
            2,
            4,
            "ЗАМЕНИТЬ_ВОПРОС_2",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "ПРАВИЛЬНЫЙ_ОТВЕТ"
        )
        questionsDataList.add(question2)

        val question3 = DataQuestionModel(
            3,
            2,
            "ЗАМЕНИТЬ_ВОПРОС_3",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "ПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ"
        )
        questionsDataList.add(question3)

        val question4 = DataQuestionModel(
            4,
            3,
            "ЗАМЕНИТЬ_ВОПРОС_4",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "ПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ"
        )
        questionsDataList.add(question4)

        val question5 = DataQuestionModel(
            5,
            1,
            "ЗАМЕНИТЬ_ВОПРОС_5",
            "ПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ"
        )
        questionsDataList.add(question5)

        val question6 = DataQuestionModel(
            6,
            3,
            "ЗАМЕНИТЬ_ВОПРОС_6",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "ПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ"
        )
        questionsDataList.add(question6)

        val question7 = DataQuestionModel(
            7,
            4,
            "ЗАМЕНИТЬ_ВОПРОС_7",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "ПРАВИЛЬНЫЙ_ОТВЕТ"
        )
        questionsDataList.add(question7)

        val question8 = DataQuestionModel(
            8,
            1,
            "ЗАМЕНИТЬ_ВОПРОС_8",
            "ПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ"
        )
        questionsDataList.add(question8)

        val question9 = DataQuestionModel(
            9,
            3,
            "ЗАМЕНИТЬ_ВОПРОС_9",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "ПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ"
        )
        questionsDataList.add(question9)

        val question10 = DataQuestionModel(
            10,
            2,
            "ЗАМЕНИТЬ_ВОПРОС_10",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "ПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ",
            "НЕПРАВИЛЬНЫЙ_ОТВЕТ"
        )
        questionsDataList.add(question10)

        return questionsDataList
    }
}