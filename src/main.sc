require:requirements.sc

theme: /

    state: Start
        q!: $regex</start>
        a: Добрый день! Я виртуальный помощник банка «Рога и Копыта»!<br/>Чем могу помочь?
        
    #ШАГ2
    state: cardsGoal
        q: * {[$wants] * $card * ($order | $design)}*
        a:  Позвольте уточнить, для каких целей вам нужна карта:<br/>
            - оплата в магазинах;<br/>
            - снятие наличных;<br/>
            - зачисление социальных выплат или пенсии;<br/>
            - зачисление заработной платы;
            
        #ШАГ3        
        state: socialPayments
            q: * $socialPayments *
            q!: * {[$wants] * $socialPayments * ($order | $design | $card)} *
            a: В соответствии с законодательством (161 ФЗ) выплаты должны осуществляться на карты национальной платежной системы "МИР".
               Банк «Рога и Копыта» предлагает клиентам карты системы (МИР) типов.<br/>
               Народная карта МИР. Ознакомиться с условиями можно по ссылке: https://www.example.com<br/>
               Универсальная карта МИР. Ознакомиться с условиями можно по ссылке: https://www.<br/>
               example.com    
            go!: /areYouReadyToOrderCard
            
        #ШАГ4
        state: pension
            q: * $pension *
            q!: * {[$wants] * $pension * ($order | $design | $card)} *
            a: В соответствии с законодательством (161 ФЗ) зачисление пенсии должно осуществляться на карты национальной платежной системы «МИР». Банк«Рога и Копыта» предлагает своим клиентам выгодные условия по Пенсионной карте «МИР». Ознакомиться с тарифами можно по ссылке: https://www.example.com

        #ШАГ5    
        state: whatIsImportant
            q: * ($payments * $salary * $paymentCards) *
            q!: * {[$wants] * $card * ($payments * $salary * $paymentCards)} *
            a: Укажите, что для вас важнее:<br/>
               -кешбэк;<br/> 
               -начисление процентов на остаток;<br/>
               -повышенный лимит снятия наличных;
    
            #ШАГ6
            state: cashback
                q!: * $cashback *
                q: * {[$wants] * $cashback * $card} *
                a: Предлагаю рассмотреть Универсальную карту (MasterCard/ VISA). Ознакомиться с условиями можно на нашем официальном сайте: https://www.example.com
                go!: /cardsGoal/whatIsImportant/premialCads
                
            #ШАГ7
            state: premialCads
                a: Также предлагаю рассмотреть альтернативный вариант - Премиальная карта (MasterCard Premium/VISA Premium). Ознакомиться с условиями можно на нашем официальном сайте: https://www.example.com
                go!: /areYouReadyToOrderCard
            
            #ШАГ8
            state: cashWithDrawal
                q: * $limits *
                q!: * {[$wants] * $limits * $card} *
                a: На каждом тарифном плане установлены лимиты на снятие собственных денежных средств без комиссии в месяц. Укажите, какие лимиты вас интересуют:<br/>
                   - снятие до 250 000 руб. в месяц без комиссии;<br/>
                   - снятие до 500 000 руб. в месяц без комиссии;<br/>
                   - снятие 1 000 000 руб. в месяц без комиссии.

                #ШАГ9
                state: universalVisaMaster
                    q: * $250 *
                    a: Предлагаю рассмотреть Универсальную карту (MasterCard/ VISA). Ознакомиться с условиями можно на нашем официальном сайте: https://www.example.com
                    go!: /cardsGoal/whatIsImportant/cashWithDrawal/CardMIR
                        
                #ШАГ10
                state: universalMIR
                    a: Также предлагаю рассмотреть альтернативный вариант - Универсальная карта «МИР». Ознакомиться с условиями можно на нашем официальном сайте: https://www.example.com
                    go!: /areYouReadyToOrderCard
                    
                #ШАГ11
                state: premialVisaMaster
                    q: * $500 *
                    a: Предлагаю рассмотреть Премиальную карту (MasterCard Premium/VISA Premium). Ознакомиться с условиями можно на нашем официальном сайте: https://www.example.com
                    go!: /cardsGoal/whatIsImportant/cashWithDrawal/platinumVisa
                    
                #ШАГ12
                state: platinumVisa
                    a: Также предлагаю рассмотреть альтернативный вариант - Эксклюзивная карта (VISA Platinum). Ознакомиться с условиями можно на нашем официальном сайте: https://www.example.com
                    go!: /areYouReadyToOrderCard
                    
                #ШАГ13
                state: exclusiveVisa
                    q: * $million *
                    a: Предлагаю рассмотреть Эксклюзивную карту (VISA Platinum). Ознакомиться с условиями можно на нашем официальном сайте: https://www.example.com
                    go!: /cardsGoal/whatIsImportant/cashWithDrawal/premialMasterVisa
                    
                #ШАГ14
                state: premialMasterVisa
                    a: Также предлагаю рассмотреть альтернативный вариант - Премиальная карта (MasterCard Premium/VISA Premium). Ознакомиться с условиями можно на нашем официальном сайте: https://www.example.com
                    go!: /areYouReadyToOrderCard    
                   
            #ШАГ15        
            state: freeService
                q: * ($freePaymentCards | $application | $free)*
                q!: * {[$wants] * ($order | $design | $card) * ($freePaymentCards | $application | $free)} *
                a: Банк «Рога и Копыта» предлагает клиентам карты системы «МИР» нескольких типов:
                   - Народная карта «МИР». Ознакомиться с условиями можно по ссылке: https://www.example.com
                   - Универсальная карта «МИР». Ознакомиться с условиями можно по ссылке: https://www.example.com
                go!: /cardsGoal/whatIsImportant/freeService/pensionMIR 
                
                #ШАГ16        
                state: pensionMIR
                    a: Если вы являетесь пенсионером, то предлагаю рассмотреть Пенсионную карту «МИР». Ознакомиться с тарифами можно на сайте: https://www.example.com
                    go!: /areYouReadyToOrderCard   
    

        
    state: areYouReadyToOrderCard
        a: Вы готовы заказать карту?
        
        state: yes
            q: * $yes *
            go!: /areYouReadyToOrderCard/makeRequest
        state: no
            q: * $no *
            go!: /areYouReadyToOrderCard/questions
        
        #ШАГ17      
        state: makeRequest
            a: Я предлагаю оформить заявку на сайте нашего банка: https://www.example.com<br/>
               Альтернативным способом заказа является посещение офиса.<br/>
               Благодарим за обращение в банк «Рога и Копыта»!
            script:
                $jsapi.stopSession();
                
    
        state: questions
            a: У вас остались вопросы?
            
            state: yes
                q: * $yes *
                go!: /areYouReadyToOrderCard/questions/operator
            state: no
                q: * $no *
                go!: /areYouReadyToOrderCard/questions/thanksForContacting
            
            state: operator
                a: Соединяю с оператором

            #ШАГ18     
            state: thanksForContacting
                a: Благодарим за обращение в банк «Рога и Копыта»!
                script:
                    $jsapi.stopSession();
            
    state: NoMatch || noContext = true
        event!: noMatch
        random:
            a: Не смог разобрать :( Попробуете сказать иначе?
            a: Простите, я не понял вас. Давайте попробуем еще раз?
            a: Извините, я не понял. Попробуйте сформулировать по-другому        